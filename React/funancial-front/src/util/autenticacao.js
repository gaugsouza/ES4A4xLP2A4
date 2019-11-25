import axios from 'axios';

const saveUser = usuario => axios.post('http://localhost:8080/usuario/', usuario);
const logarUsuario = usuario => axios.post('http://localhost:3000/api/usuarios/login',usuario);

export {
    saveUser,
    logarUsuario
}
