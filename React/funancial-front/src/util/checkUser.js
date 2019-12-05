const checkUserLogado = () =>{
    let usuarioLogado = JSON.parse(localStorage.getItem("usuarioLogado"));
    return usuarioLogado !== null && usuarioLogado !== undefined;
}

export {
    checkUserLogado
}