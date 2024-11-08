import React from 'react';
import { AgGridReact } from 'ag-grid-react';
import {Link} from 'react-router-dom';
import {Upload} from "../../shared/shared.service";
import "./listemployeescreen.scss";
import  {service}   from './listemployeescreen.service';
import  BootstrapTable   from 'react-bootstrap-table-next';
import  paginationFactory   from 'react-bootstrap-table2-paginator';
import  'react-bootstrap-table2-paginator/dist/react-bootstrap-table2-paginator.min.css'  ;
import  'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css'  ;

class Listemployeescreen extends React.Component<any, any> {
    columnDefs: any = [{ dataField: 'name', text: 'name' },{ dataField: 'empid', text: 'empid' },{ dataField: 'role', text: 'role' },];
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
    this.GetAllValues();
    }
    GetAllValues  () {
    this.test.GetAllValues().then((data:any) => {
    this.setState({rowData:data.data})
    },
    (error:any) => {
    console.log('Error', error);
    });
    }
    rowclick ={onClick: (e: any, row: any, rowIndex: any) => 
    {this.props.history.push({ pathname: "/",state:{id:row} });
    }}

    render(){
    return(
    <>
        <h2 className="screen-align">listemployeescreen</h2>
        <div>
    <div id="template-ijxq">
        <div id="template-i0vg">
            <div id="template-iiwn">
                <div id="template-ibmk">
                    <div>
                        <BootstrapTable keyField='_id' data={this.state.rowData} columns={this.columnDefs}
                        rowEvents={this.rowclick} pagination={paginationFactory({ sizePerPageList:
                        [{ text: '5', value: 5 }, { text: '25', value: 25 }, { text: '50', value:
                        50 }], } ) } />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    </>
    );
    };
    };

    export default Listemployeescreen;