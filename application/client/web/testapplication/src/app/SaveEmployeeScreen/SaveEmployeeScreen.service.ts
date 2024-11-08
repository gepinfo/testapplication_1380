import axios from 'axios';
import React from "react";
import { Web } from '../../shared/shared.service';



export class service extends React.Component { 



   Create=(employeemanagement:any) => {
        let jwt_token = sessionStorage.getItem('JwtToken');
 	 	return axios.post(Web() + '/employeemanagement' + `?jwt_token=${jwt_token}`, employeemanagement);
    }
}