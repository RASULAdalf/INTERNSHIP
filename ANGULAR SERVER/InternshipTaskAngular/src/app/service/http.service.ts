import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http:HttpClient) { }

  public post(url:any,data:any):Observable<any>{
    return this.http.post(url,data)
  }
  public put(url:any,data:any):Observable<any>{
    return this.http.put(url,data)
  }

  public get(url: any):Observable<any> {
    return this.http.get(url)
  }

  public delete(url: any):Observable<any> {
    return this.http.delete(url);
  }
}

