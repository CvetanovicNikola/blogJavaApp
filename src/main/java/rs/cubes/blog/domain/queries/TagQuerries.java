package rs.cubes.blog.domain.queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import rs.cubes.blog.domain.Tag;

public class TagQuerries {
	
	public static List<Tag> getAllTags(EntityManager em, String value, boolean like){
		if(like==true && value != null) {
			}
		String q = "select t from Tag t";
		
		if(value != null && like ==false) {
			q += "where t.value like concat('%', :value,'%')";
	}
		TypedQuery<Tag>query = em.createQuery(q, Tag.class);
		if(value != null) {
			query.setParameter("value", value);
			}
		return query.getResultList();
		}
	public static Tag getTagById(EntityManager em, long id) {
		return em.find(Tag.class, id);
	}
	public static Tag getTagByValue(EntityManager em, String value) {
		String q =  "select t from Tag t where t.value = :value";
		TypedQuery<Tag>query = em.createQuery(q, Tag.class);
		query.setParameter("value", value);
		List<Tag>l = query.getResultList();
		return l.get(0);
	}

}
 