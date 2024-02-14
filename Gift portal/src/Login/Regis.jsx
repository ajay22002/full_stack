import React, { useState } from "react";
import "../LogReg.css";
import { Link, useNavigate} from "react-router-dom";
import { signUp } from "../service/auth";

const Reg = () => {
  const navigate = useNavigate();
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    // Perform any validation here
    if (password.length < 6) {
      setError("Password must be at least 6 characters long");
    } else {
      const userDetails = { name:name, email:email, password:password };
      signUp(userDetails)
      console.log(userDetails)
      localStorage.setItem("Userdetail", JSON.stringify(userDetails));
      navigate('/login');
    }
  }

  return (
    <> 
    <div className="Signup">
      <div className="SignupContainer">
        <div className="child">
          <h1 className="primary-dark">NEW ACCOUNT</h1>
          <form onSubmit={handleSubmit}>
            <div className="fields">
              <label className="nav__list">Your Name</label>
              <input
                className="input"
                type="text"
                name="name"
                required
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
              <label className="nav__list">Your Email</label>
              <input
                className="input"
                type="email"
                name="email"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
              <label className="nav__list">Password</label>
              <input
                className="input"
                type="password"
                name="password"
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              {error && <p className="error">{error}</p>}
            </div>
            <button className="btn blue-gradient-bg">Register</button>
          </form>
          <div className="existingUser">
            <p className="Alreadyaccount">
              Already have an account? <Link to="/login">Login here</Link>
            </p>
          </div>
        </div>
      </div>
    </div>
    </>
  );
};

export default Reg;