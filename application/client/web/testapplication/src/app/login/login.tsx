import React, { useEffect, useState } from "react";
import "./login.scss";
import { Button, Form, FormGroup, Label, Input, FormText } from "reactstrap";
import logo from "../../assets/img/Group2704.png";
import { Consent, login } from "./login.services";
import { useHistory } from "react-router-dom";

const Login = (props: any) => {
  let id: any;
  let userDetails: any;
  let openId: String = "openid";
  let permission: any[] = [];
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });
  const [errorMessage, seterrorMessage] = useState("");
  const { email, password } = formData;
  const [visibility, setvisibility] = useState(false);

  const history = useHistory();

  const onChange = (e: any) =>
    setFormData({ ...formData, [e.target.name]: e.target.value });
  const showPassword = () => {
    setvisibility(!visibility);
  };
  const onSubmit = async (e: any) => {
    e.preventDefault();
    const data = JSON.stringify(formData);
    console.log('data',data);
    
    login(data).then((logindatas: any) => {

      console.log('logindatas',logindatas.data.id
      );

      sessionStorage.setItem(
        "Name",
        logindatas.data.firstname +
          " " +
          logindatas.data.lastname
      );
      // if(logindatas.data.avatar !== null){

      //   sessionStorage.setItem('Image', logindatas.data.avatar);
      //       }else {
      let name = logindatas.data.firstname;
      id = logindatas.data.id;
     console.log('id------',id);
     
      let image = `../../assets/profile/${name}.png`;
      sessionStorage.setItem("Image", image);
      // }
      let tokenError = logindatas.data.error;
      if (userDetails === "Incorrect Username or Password") {
        seterrorMessage(userDetails);
      } else {
        if (tokenError !== undefined) {
          if (tokenError.name === "TokenExpiredError") {
            consent(logindatas.data.id);
          }
        } else {
          if (logindatas.data.Access) {
            consent(logindatas.data.id);
          } else {
           id = logindatas.data.id;
            sessionStorage.setItem("Id", logindatas.data.Userdetails.id);
            sessionStorage.setItem(
              "lastLoggedInTime",
              logindatas.data.loggedinDate
            );
            sessionStorage.setItem("email", logindatas.data.Userdetails.id);
            sessionStorage.setItem(
              "JwtToken",
              logindatas.data.idtoken
            );
            if (
              logindatas.data.idtoken === null ||
              logindatas.data.idtoken === ""
            ) {
              consent(logindatas.data.id);
            } else {
              window.location.href = "/sefscreen";
              console.log('calll else');
              
            }
          }
        }
       
      }
    });
  };

  const consent = (id:any) => {
      
    const temp = {
      id: id,
      submit: "Allow access",
      scope: openId,
    };
    Consent(temp).then((consentValue: any) => {
      const { data } = consentValue; // Extract `data` for easier access
      console.log('consentValue', consentValue);
      console.log('consentValuedata', data);
      console.log('consentValueAccess', data?.Access);
  
      // Check if 'Access' exists and is valid
      if (data?.Access?.length > 0) {
          const accessLevel = data.Access[0];
          console.log('accessLevel', accessLevel);
  
          // Assuming permission is defined elsewhere in the scope
          permission.push(accessLevel);
          sessionStorage.setItem("Access", JSON.stringify(permission));
      }
  
      // Instead of manually declaring 'screen', directly use the correct structure
      const defaultScreens = [
          { "screenname": "sefscreen" },
          { "screenname": "home" },
          { "screenname": "SaveEmployeeScreen" },
          { "screenname": "listemployeescreen" },
          { "screenname": "updateemployee" }
      ];
  
      // Parse and access screens from session storage or use the default
      const screens = JSON.parse(sessionStorage.getItem("screens") || JSON.stringify(defaultScreens))[0];
      const accessScreen = screens?.[Object.keys(screens)[0]]?.screens || [];
      sessionStorage.setItem("screens", JSON.stringify(accessScreen));
  
      // Extract user details and log them
      const { Userdetails } = data;
      console.log('userDetails', Userdetails);
  
      if (Userdetails) {
          const { id, loggedinDate, email, idtoken } = Userdetails;
  
          // Store user session information
          sessionStorage.setItem("Id", id);
          sessionStorage.setItem("lastLoggedInTime", loggedinDate);
          sessionStorage.setItem("email", email);
          sessionStorage.setItem("JwtToken", idtoken);
  
          // Redirect to the appropriate screen
          window.location.href = "/sefscreen";
      }
  });
  

    // Consent(temp).then((consentValue: any) => {
    //    console.log('consentValue',consentValue);
    //    console.log('consentValuedata',consentValue.data);
    //    console.log('consentValueaccess',consentValue.data.Access);
       
    //   if (consentValue.data.Access !== undefined) {
    //     let accessLevel = consentValue.data.Access[0];
    //     console.log('accessLevel',accessLevel);
        
    //     permission.push(accessLevel);
    //     sessionStorage.setItem("Access", JSON.stringify(permission));
    //   }
    //   // let screen: any = sessionStorage.getItem("Access");
    //   let screen:any =  [[
    //     {
    //         "screenname": "sefscreen"
    //     },
    //     {
    //         "screenname": "home"
    //     },
    //     {
    //         "screenname": "saveemployeescreen"
    //     },
    //     {
    //         "screenname": "listemployeescreen"
    //     },
    //     {
    //         "screenname": "updateemployee"
    //     }
        
    // ] ]
    //   let screens = JSON.parse(screen)[0];
    //   let accessscreen = screens[Object.keys(screens)[0]].screens;
    //   sessionStorage.setItem("screens", JSON.stringify(accessscreen));
    //   userDetails = consentValue.data.Userdetails;
    //   console.log('userDetails',userDetails);
      
    //   let id = userDetails.id;
    //   let lastLoggedInTime = userDetails.loggedinDate;

    //   window.location.href = "/sefscreen";
    //   sessionStorage.setItem("Id", id);
    //   sessionStorage.setItem("lastLoggedInTime", lastLoggedInTime);
    //   sessionStorage.setItem("email", userDetails.email);
    //   sessionStorage.setItem("JwtToken", userDetails.idtoken);
    // });
  };
  return (
    <div className="background-images">
      <div className="container left_align">
        <div className="row">
          <div className="col-lg-4"></div>
          <div className="col-lg-4">
            <div className="main">
              <div className="geppetto-img">
                <img src={logo} />
              </div>
              <div className="login-Wrappe text-left ">
                <h3 className="login-title">Please login</h3>
                <div className="text-align-left">
                  <Form onSubmit={(e: any) => onSubmit(e)}>
                    <FormGroup>
                      <Label className="login-label" for="exampleEmail">
                        Email
                      </Label>
                      <Input
                        className="login-input"
                        type="text"
                        name="email"
                        value={email}
                        id="exampleEmail"
                        placeholder="Email"
                        onChange={(e: any) => onChange(e)}
                      />
                    </FormGroup>
                    <FormGroup>
                      <Label className="login-label" for="examplePassword">
                        Password
                      </Label>
                      <Input
                        className="login-input"
                        type={visibility ? "text" : "password"}
                        name="password"
                        value={password}
                        id="examplePassword"
                        placeholder="password"
                        onChange={(e: any) => onChange(e)}
                      />
                      <span
                        style={{ cursor: "pointer" ,opacity: 0.5}}
                        onClick={showPassword}
                      >
                        showPassword
                      </span>
                    </FormGroup>
                    <div className="text-center mb-3">
                      <Button className="login-btn-width">Submit</Button>
                    </div>
                  </Form>
                </div>
                <span className="signup-text-color">
                  Please Login or{" "}
                  <span
                    className="span-text-link"
                    onClick={() => props.history.push("/signup")}
                  >
                   Signup
                  </span>
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default Login;
