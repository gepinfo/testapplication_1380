import React from 'react';
import { AgGridReact } from 'ag-grid-react';
import {Link} from 'react-router-dom';
import {Upload} from "../../shared/shared.service";
import "./updateemployee.scss";
import  {service}   from './updateemployee.service';

class Updateemployee extends React.Component<any, any> {
    test = new service ("");
    constructor(props:any){
    super(props);
    this.state={
    employee : {
    name: '',
    empid: '',
    role: '',
    },
    
    rowData :[]
    } }


    handlechange = (e: any) => {
    if(e?.target){
    this.setState({ employee: { ...this.state.employee, [e.target.name]: e.target.value } })
    }
    }


    componentDidMount() {
    this.state.employee.created_by = sessionStorage.getItem('email')||'{}';
    }

    render(){
    return(
    <>
        <h2 className="screen-align">updateemployee</h2>
        <div>
    <div id="template-i212">
        <div id="template-iwn8" className="gjs-row">
            <div id="template-ifix" className="gjs-cell">
                <input type="text" id="template-i3ux8" placeholder="name" required={true}onChange={this.handlechange}
                name="name" value={this.state.employee.name}className="form-control " />
            </div>
            <div id="template-iohh" className="gjs-cell">
                <input type="text" id="template-ig79i" placeholder="empid" required={true}onChange={this.handlechange}
                name="empid" value={this.state.employee.empid}className="form-control "
                />
            </div>
        </div>
        <div id="template-i0rp" className="gjs-row">
            <div id="template-itoy" className="gjs-cell">
                <input type="text" id="template-ivvhu" placeholder="role" required={true}onChange={this.handlechange}
                name="role" value={this.state.employee.role}className="form-control " />
            </div>
        </div>
        <div id="template-izni" className="gjs-row">
            <div id="template-i39o" className="gjs-cell">
                <button type="button" id="template-i1t7g" onClick={()=>this.Update()} className="btn btn-primary "></button>
            </div>
        </div>
    </div>
</div>
    </>
    );
    };
    };

    export default Updateemployee;