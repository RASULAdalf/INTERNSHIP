import {Injectable, NgZone} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AngularFirestore, AngularFirestoreDocument} from "@angular/fire/compat/firestore";
import {AngularFireAuth} from "@angular/fire/compat/auth";
import {SystemUser} from "../model/SystemUser";
import firebase from "firebase/compat/app";
import GoogleAuthProvider = firebase.auth.GoogleAuthProvider;

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private userData: any

  constructor(private activatedRoute: ActivatedRoute, private router: Router, public afs: AngularFirestore, public afAuth: AngularFireAuth, public ngZone: NgZone) {
    this.setLoggingStateFirebase();
  }

    public async isLoggedFirebase(): Promise<any> {
    return new Promise((resolve, reject) => {
      // @ts-ignore
      (JSON.parse(localStorage.getItem('user')).email!==undefined) ? resolve(true):reject(false);
    });
  }

  SignIn(email: string, password: string) {
    return this.afAuth.signInWithEmailAndPassword(email, password);
  }

  SetUserData(user: any) {
    const userRef: AngularFirestoreDocument<any> = this.afs.doc(
      `users/${user.uid}`
    );
    const userData: SystemUser = {
      uid: user.uid,
      email: user.email,
      displayName: user.displayName,
      photoURL: user.photoURL,
      emailVerified: user.emailVerified,
    };
    return userRef.set(userData, {
      merge: true,
    });
  }

  public SignUp(email: string, password: string): Promise<any> {
    return new Promise((resolve, reject) => {
      this.afAuth
        .createUserWithEmailAndPassword(email, password)
        .then((result) => {
          /* Call the SendVerificaitonMail() function when new user sign
          up and returns promise */
          this.SendVerificationMail();
          this.SetUserData(result.user).then(r => resolve(true));

        })
        .catch((error) => {
          window.alert(error.message);
          reject(false);
        });
    })
  }

  SendVerificationMail() {
    return this.afAuth.currentUser
      .then((u: any) => u.sendEmailVerification())
      .then(() => {
        //this.router.navigate(['verify-email-address']);
      });
  }

  ForgotPassword(passwordResetEmail: string) {
    return this.afAuth
      .sendPasswordResetEmail(passwordResetEmail)
      .then(() => {
        window.alert('Password reset email sent, check your inbox.');
      })
      .catch((error) => {
        window.alert(error);
      });
  }

  GoogleAuth() {
    return this.AuthLogin(new GoogleAuthProvider());

  }

  private AuthLogin(provider: any) {
    return this.afAuth
      .signInWithPopup(provider)
      .then((result) => {
        this.ngZone.run(() => {
          this.afAuth.authState.subscribe((user) => {
            if (user) {
              this.userData = user;
              localStorage.setItem('user', JSON.stringify(this.userData));
              JSON.parse(localStorage.getItem('user')!);
             // this.router.navigate(['VendorDashboard']);
            } else {
              localStorage.setItem('user', 'null');
              JSON.parse(localStorage.getItem('user')!);
            }
          });
        });
        this.SetUserData(result.user);
      })
      .catch((error) => {
        window.alert(error);
      });
  }

  SignOut() {
    return this.afAuth.signOut().then(() => {
      localStorage.removeItem('user');
      //this.router.navigate(['/landing']);
    });
  }

  setLoggingStateFirebase() {
    this.afAuth.authState.subscribe((user) => {
      if (user) {
        this.userData = user;
        localStorage.setItem('user', JSON.stringify(this.userData));
        JSON.parse(localStorage.getItem('user')!);
      } else {
        localStorage.setItem('user', 'null');
        JSON.parse(localStorage.getItem('user')!);
      }
    });
  }

  forgotPassword(email: any) {
    this.ForgotPassword(email).then(res => {
      //this.router.navigate(['/landing'], {queryParams: {err: `Reset link sent to ${email}`}});
    }, err => {
      //this.router.navigate(['/landing'], {queryParams: {err: err}});
    })
  }


}
