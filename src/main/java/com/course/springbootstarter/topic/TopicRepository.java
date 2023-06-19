package com.course.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> { // <Entity class we are working with, Type of PrimaryKey>

}
