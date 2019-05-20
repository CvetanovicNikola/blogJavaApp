package rs.cubes.blog.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.cubes.blog.domain.Tag;
import rs.cubes.blog.domain.queries.TagQuerries;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;

@Stateless
public class TagService {
	
	@PersistenceContext
	EntityManager em;
	
	public Tag createTag(Tag tag) {
		if(tag.getValue().length() > 20) {
			throw new AppException(ErrorMessage.tagTooLong);
			}
		
		Tag t = TagQuerries.getTagByValue(em, tag.getValue());
		
		if (t != null) {
			throw new AppException(ErrorMessage.tagAlreadyExists);
		}
		em.persist(tag);
		return t;
	}
	public List<Tag> getAllTags(String value, boolean like){
		List<Tag> tags = TagQuerries.getAllTags(em, value, like);
		return tags;
	}
	public Tag getTag(long id) {
		Tag t = em.find(Tag.class, id);
		
		if (t == null) {
			throw new AppException(ErrorMessage.noSuchTag);
		}
		return t;
	}
	public void deleteTag(long id) {
		Tag t = TagQuerries.getTagById(em, id);
		if(t == null) {
			throw new AppException(ErrorMessage.noSuchTag);
		}
		em.remove(t);
	}
} 
