package com.example.hck1.TiposGrupos;

import com.example.hck1.Grupo.Group;
import com.example.hck1.Grupo.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoGrupoService {

    @Autowired
    private TipoGrupoRepository tipoGrupoRepository;

    @Autowired
    private GroupService groupService;

    public List<TipoGrupo> getAllTipos() {
        return tipoGrupoRepository.findAll();
    }

    public TipoGrupo getTipoById(Long id) {
        return tipoGrupoRepository.findById(id).orElse(null);
    }

    public TipoGrupo createTipoGrupo(TipoGrupo tipoGrupo) {
        return tipoGrupoRepository.save(tipoGrupo);
    }

    public List<Group> getTipoGrupo(Long id) {
        return tipoGrupoRepository.findById(id).orElse(null).getGrupos();
    }

    public TipoGrupo addGroupToTipo(Long id, Long groupId) {
        TipoGrupo tipoGrupo = tipoGrupoRepository.findById(id).orElse(null);
        if (tipoGrupo != null) {
            tipoGrupo.getGrupos().add(groupService.getGroupById(groupId));
            return tipoGrupoRepository.save(tipoGrupo);
        } else {
            return null;
        }
    }
    public boolean deleteTipoGroup(Long id){
        Optional<TipoGrupo> optionalTipoGroup = tipoGrupoRepository.findById(id);
        if(optionalTipoGroup.isPresent()){
            tipoGrupoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}