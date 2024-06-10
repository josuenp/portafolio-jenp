const textoIngresado = document.getElementById('type-text');
const textoDeVuelta = document.getElementById('second-text');
const botonCifrar = document.getElementById('cifrado')

let codigo = [
    ['e','enter'],
    ['o','ober'],
    ['i','imes'],
    ['a','ai'],
    ['u','ufat'],
];

botonCifrar.addEventListener('click', () =>{
    const textoInicio = textoIngresado.value.toLowerCase();
    function encriptar(textoNuevo) {
        for ( let i = 0; i < codigo.length; i++){
            if (textoNuevo.includes(codigo[i][0])){
                textoNuevo = textoNuevo.replaceAll(codigo[i][0], codigo[i][1]);
            };
            
        };
        return textoNuevo
    }
    const texto1 = encriptar(textoInicio);

    textoDeVuelta.innerHTML = texto1
})