import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './routers/App';
import {BrowserRouter} from "react-router-dom";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import 'bootstrap/dist/css/bootstrap.css';
import AuthProvider from "./Context/AuthProvider";
import HttpHeaderProvider from "./Context/HttpHeaderProvider";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
        <AuthProvider>
            <HttpHeaderProvider>
                <Header/>
                <App/>
                <Footer/>
            </HttpHeaderProvider>
        </AuthProvider>
    </BrowserRouter>
);
