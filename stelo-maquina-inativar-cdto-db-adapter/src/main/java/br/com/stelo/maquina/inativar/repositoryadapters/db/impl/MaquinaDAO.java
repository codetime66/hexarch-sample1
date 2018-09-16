package br.com.stelo.maquina.inativar.repositoryadapters.db.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.stelo.maquina.inativar.repositoryadapters.db.IMaquinaDAO;
import br.com.stelo.maquina.inativar.repositoryadapters.db.entity.MaquinaEntity;

@Transactional
@Repository
public class MaquinaDAO implements IMaquinaDAO {

	@PersistenceContext	
	private EntityManager entityManager;
		
	//@Override
	//public MaquinaEntity getMaquinaById(String nuSerie) {
	//	return entityManager.find(MaquinaEntity.class, nuSerie);
	//}

	@Override
	public boolean inativar(String nuserie) {
		StringBuilder hql = new StringBuilder();	
		hql.append("update USR_CADU.TB_MAQNA_CATAO ");
		hql.append(" set sttus_maqna = 'I', id_sttus_mdulo_term = '5' "); 
		hql.append(" where sttus_maqna = 'A' and nu_serie =:nuSerie ");

		Query query = entityManager.createNativeQuery(hql.toString());
        query.setParameter("nuSerie", nuserie);

        int updl = query.executeUpdate();
        return updl>0;		
	}

	@Override
	public boolean inativar(Long nuTerm, String nuSerie) {
		StringBuilder hql = new StringBuilder();	
		hql.append("update USR_CADU.TB_MAQNA_CATAO ");
		hql.append(" set sttus_maqna = 'I', id_sttus_mdulo_term = '5' "); 
		hql.append(" where nu_term = :nuTerm and nu_serie =:nuSerie ");

		Query query = entityManager.createNativeQuery(hql.toString());
		query.setParameter("nuTerm", nuTerm);
        query.setParameter("nuSerie", nuSerie);

        int updl = query.executeUpdate();
        return updl>0;
	}
	
	@Override
	public boolean maquinaExists(String nuSerie) {
		String hql = "FROM Maquina as maq WHERE maq.nuSerie = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, nuSerie)
		              .getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public MaquinaEntity getMaquinaByNuSerie(String nuSerie) {
		MaquinaEntity maquina = null;
		String hql = "FROM "+MaquinaEntity.class.getName()+" as maq WHERE maq.sttusMaqna = 'A' and maq.nuSerie = ? ";
		@SuppressWarnings("unchecked")
		List<MaquinaEntity> maquinas = entityManager.createQuery(hql).setParameter(1, nuSerie)
		              .getResultList();
		if(maquinas!=null && !maquinas.isEmpty()) {
		    maquina = (MaquinaEntity) maquinas.get(0);
		}
		return maquina;
	}
	
}
