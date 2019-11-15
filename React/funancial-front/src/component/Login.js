import React, { useEffect } from 'react';

const Login = ({setTitle}) => {
    useEffect(() =>{
        setTitle('Login');
    })
    return(<div className='login'>
        Login
    </div>)
}

export default Login;
