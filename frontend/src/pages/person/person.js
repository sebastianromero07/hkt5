import { useEffect, useState } from "react"
import { fetchPersons } from "../../api/dataService"
import 'devextreme/data/odata/store';
import DataGrid, { Column,Pager,Paging,FilterRow, } from 'devextreme-react/data-grid';


export default function Person(){
    // Se declara un estado llamado 'groupsWithPersonCount' utilizando useState.
    const [personsWithGroupCount, setPersonsWithGroupCount] = useState();

    useEffect(() => {
        fetchPersons()
          .then((response) => {
            // Extrae los datos de respuesta de la solicitud.
            const personsData = response.data;
    
            // Registra los datos de grupos en la consola.
            console.log(personsData);

            setPersonsWithGroupCount(personsData.map(person => ({
                id: person.id,
                name: person.name    
              })));
              console.log(personsWithGroupCount);

          })
          .catch((error) => {
            console.log(error);
          })
      }, []); // El [] como segundo argumento asegura que useEffect se ejecute solo una vez al montar el componente.
    
      return (
        <DataGrid
          // Establece la fuente de datos para el DataGrid como 'groupsWithPersonCount'.
          dataSource={personsWithGroupCount}
          
          // Muestra bordes alrededor de las celdas de la tabla.
          showBorders={true}
        >
          {/* Define la primera columna con el campo 'id' y un ancho de 50 píxeles. */}
          <Column 
          dataField="id" 
          width={50} 
          />
          
          {/* Define la segunda columna con el campo 'name'. */}
          <Column 
          dataField="name" 
          />
  
          <Paging defaultPageSize={10} />
          <Pager showPageSizeSelector={true} showInfo={true} />
          <FilterRow visible={true} />
        </DataGrid>
  
    )
}