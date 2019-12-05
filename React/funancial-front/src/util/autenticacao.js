import axios from 'axios';

const saveUser = usuario => axios.post('http://localhost:8080/login/cadastro', usuario);
const logarUsuario = usuario => axios.post('http://localhost:8080/login', usuario);

export {
    saveUser,
    logarUsuario
}
