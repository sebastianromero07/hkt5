import { useEffect, useState } from "react"
import { fetchGroups } from "../../api/dataService"
import 'devextreme/data/odata/store';
import DataGrid, { Column,Pager,Paging,FilterRow, } from 'devextreme-react/data-grid';

export default function Group() {
  const [groupsWithPersonCount, setGroupsWithPersonCount] = useState();

  useEffect(() => {
    fetchGroups()
      .then((response) => {
        const groupsData = response.data;

        console.log(groupsData);

        setGroupsWithPersonCount(groupsData.map(group => ({
          id: group.id,
          name: group.name,
          tipoGrupo: group.tipoGrupo.name
        })));
        console.log(groupsWithPersonCount);
      })
      .catch((error) => {
        console.log(error);
      })
  }, []); // El [] como segundo argumento asegura  usqueeEffect se ejecute solo una vez al montar el componente.

  return (
      <DataGrid
        // Establece la fuente de datos para el DataGrid como 'groupsWithPersonCount'.
        dataSource={groupsWithPersonCount}
        
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
        
        {/* Define la tercera columna con el campo 'personCount' y un título personalizado 'Number of Persons'. */}
        <Column 
        dataField="tipoGrupo" 
        caption="Tipo de Grupo" 
        />

        <Paging defaultPageSize={10} />
        <Pager showPageSizeSelector={true} showInfo={true} />
        <FilterRow visible={true} />
      </DataGrid>

  )
}