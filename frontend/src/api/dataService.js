import axios from 'axios';

// Definición de la URL base para las solicitudes al servidor.
const BASE_URL = 'http://localhost:8000';

// Función asincrónica para recuperar grupos desde el servidor.
export const fetchGroups = async () => {
    // Utiliza Axios para hacer una solicitud GET a la URL de grupos.
    return axios.get(`${BASE_URL}/groups`)
}

export const fetchPersons = async () => {
    // Utiliza Axios para hacer una solicitud GET a la URL de personas.
    return axios.get(`${BASE_URL}/persons`)
}

export const fetchTipoGroup = async () => {
    // Utiliza Axios para hacer una solicitud GET a la URL de personas.
    return axios.get(`${BASE_URL}/tipos`)
}


