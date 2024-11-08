import React from 'react';
import { AgGridReact } from 'ag-grid-react';
import {Link} from 'react-router-dom';
import {Upload} from "../../shared/shared.service";
import "./SaveEmployeeScreen.scss";
import  {service}   from './SaveEmployeeScreen.service';

class SaveEmployeeScreen extends React.Component<any, any> {
    test = new service ("");
    constructor(props:any){
    super(props);
    this.state={
    employee : {
    name: '',
    empid: '',
    role: ''
    },
    
    rowData :[]
    } }


    handlechange = (e: any) => {
    if(e?.target){
    this.setState({ employee: { ...this.state.employee, [e.target.name]: e.target.value } })
    }
    }


    // componentDidMount() {
    // this.state.employee.created_by = sessionStorage.getItem('email')||'{}';
    // }
    Create  () {
        console.log('this.state.employee',this.state.employee);
        
    this.test.Create(this.state.employee).then((data:any) => {
        this.setState({ employee : {
            name: '',
            empid: '',
            role: ''
            } })
    },
    (error:any) => {
    console.log('Error', error);
    });
    }

    render(){
    return(
    <>
        <h2 className="screen-align">SaveEmployeeScreen</h2>
        <div id="ii6s">
    <div id="template-ivn7" className="gjs-row">
        <div id="template-io63" className="gjs-cell">
            <input type="text" id="template-ikgv" placeholder="Enter the name" required={true}onChange={this.handlechange}
            name="name" value={this.state.employee.name}className="form-control " />
        </div>
        <div id="template-i9sg" className="gjs-cell">
            <input type="text" id="template-ie8zj" placeholder="Enter the emplyee ID"
            required={true}onChange={this.handlechange} name="empid" value={this.state.employee.empid}className="form-control "
            />
        </div>
    </div>
    <div id="template-i3ha" className="gjs-row">
        <div id="template-ib5k" className="gjs-cell">
            <input type="text" id="template-ini0f" placeholder="Enter the role" required={true}onChange={this.handlechange}
            name="role" value={this.state.employee.role}className="form-control " />
        </div>
    </div>
    <div id="template-iyidi" className="gjs-row">
        <div id="template-i8via" className="gjs-cell">
            <button type="button" id="template-i5t4i" onClick={()=>this.Create()} className="btn btn-primary "> save</button>
        </div>
    </div>
</div>
    </>
    );
    };
    };

    export default SaveEmployeeScreen;