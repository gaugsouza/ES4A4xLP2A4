export const nullKeyValidator = (usuario) => {
    for(let key in usuario){
        if(usuario[key] === null && key !== 'confirmaSenha'){
            throw new Error(`Campo de ${key.charAt(0).toUpperCase() + key.slice(1)} não pode ser nulo`)
        }
    }
}