import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import {BrowserRouter} from "react-router-dom";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import 'bootstrap/dist/css/bootstrap.css';
import Main from "./layout/Main";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
        <Header/>
        <App className="App"/>
        <Footer/>
    </BrowserRouter>
);
