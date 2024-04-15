package de.thb.justnoteit.repository;

import de.thb.justnoteit.entity.Notebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Notebook.class, idClass = Long.class)
public interface NotebookRepository  extends CrudRepository<Notebook, Long> {
}
