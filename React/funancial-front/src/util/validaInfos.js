export const verificarSenhas = (senha, confirmacao) =>{
    if(senha !== confirmacao){
        throw new Error('Senhas não correspondem');
    }
}