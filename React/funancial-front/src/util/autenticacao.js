import axios from 'axios';

const saveUser = usuario => axios.post('https://funancial-backend.herokuapp.com/login/cadastro', usuario);
const logarUsuario = usuario => axios.post('https://funancial-backend.herokuapp.com/login', usuario);

export {
    saveUser,
    logarUsuario
}
