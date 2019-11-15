const urlPath = [
    {
        pageName: "Tela Inicial",
        path: ""
    },{
        pageName: "Login",
        path: "login"
    },{
        pageName: "Cadastro",
        path: "cadastro"
    }
]

export const getPath = pageNameParam => urlPath.filter(obj => obj.pageName === pageNameParam)[0].path;