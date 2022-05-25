package com.example.demo.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UploadFile;

@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile, UUID> {

}
