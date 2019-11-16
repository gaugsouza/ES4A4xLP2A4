import axios from 'axios';

export const saveUser = usuario =>    axios.post('http://localhost:3000/api/usuarios/cadastro', usuario);
