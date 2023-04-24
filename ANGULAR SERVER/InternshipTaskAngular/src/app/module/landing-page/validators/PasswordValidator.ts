import {AbstractControl, ValidatorFn} from "@angular/forms";

export function PasswordValidator(field_val:any):ValidatorFn {

  return (control: AbstractControl): { [key: string]: any } => {

    const input = control.value;

    const isSame = control.root.value[field_val]===input;
    console.log(isSame)

    // @ts-ignore
    return isSame ?  null:{'PasswordValidator': {isSame}};
  };
}
