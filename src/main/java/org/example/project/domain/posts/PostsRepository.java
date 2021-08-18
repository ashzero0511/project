package org.example.project.domain.posts;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
