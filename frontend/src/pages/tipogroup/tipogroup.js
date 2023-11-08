import { useEffect, useState } from "react"
import { fetchTipoGroup } from "../../api/dataService"
import 'devextreme/data/odata/store';
import DataGrid, { Column,Pager,Paging,FilterRow } from 'devextreme-react/data-grid';


export default function TipoGroup(){
    const [tipos, setTipos] = useState();

    useEffect(() => {
      fetchTipoGroup()
          .then((response) => {
            const tiposData = response.data;
    
            console.log(tiposData);

            setTipos(tiposData.map(tipos => ({
                id: tipos.id,
                name: tipos.name
              })));
              console.log(tipos);

          })
          .catch((error) => {
            console.log(error);
          })
      }, []); // El [] como segundo argumento asegura que useEffect se ejecute solo una vez al montar el componente.
    
      return (
        <DataGrid
          // Establece la fuente de datos para el DataGrid como 'groupsWithPersonCount'.
          dataSource={tipos}
          
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