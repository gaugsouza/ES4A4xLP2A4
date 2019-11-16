import axios from 'axios';
/*
export const autenticacaoUtils = {
   saveUser = function(usuario){
       return axios.post('http://localhost:3000/api/usuarios/cadastro', usuario);
   },
   logarUsuario = function(usuario){
    axios.post('http://localhost:3000/api/usuarios/login',usuario);
   }
    
}*/

const saveUser = usuario => axios.post('http://localhost:3000/api/usuarios/cadastro', usuario);
const logarUsuario = usuario => axios.post('http://localhost:3000/api/usuarios/login',usuario);

export {
    saveUser,
    logarUsuario
}
