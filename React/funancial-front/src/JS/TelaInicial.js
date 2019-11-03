export const exibirMenu = (className) =>{
    let elements = document.getElementsByClassName(className);
    for(let i = 0; i < elements.length; i++){
        elements[i].classList.add('active');
    }
}
