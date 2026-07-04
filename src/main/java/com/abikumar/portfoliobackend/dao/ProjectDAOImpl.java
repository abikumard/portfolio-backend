package com.abikumar.portfoliobackend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abikumar.portfoliobackend.dto.ProjectDTO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveProject(ProjectDTO dto) {

        String sql = """
                INSERT INTO projects
                (
                    title,
                    description,
                    technologies,
                    github_link,
                    live_link,
                    image_url
                )
                VALUES
                (
                    ?,?,?,?,?,?
                )
                """;

        return jdbcTemplate.update(
                sql,
                dto.getTitle(),
                dto.getDescription(),
                dto.getTechnologies(),
                dto.getGithubLink(),
                dto.getLiveLink(),
                dto.getImageUrl());
    }

    @Override
    public List<ProjectDTO> getAllProjects() {

        String sql = "SELECT * FROM projects ORDER BY id DESC";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            ProjectDTO dto = new ProjectDTO();

            dto.setId(rs.getLong("id"));
            dto.setTitle(rs.getString("title"));
            dto.setDescription(rs.getString("description"));
            dto.setTechnologies(rs.getString("technologies"));
            dto.setGithubLink(rs.getString("github_link"));
            dto.setLiveLink(rs.getString("live_link"));
            dto.setImageUrl(rs.getString("image_url"));

            return dto;
        });
    }

    @Override
    public int updateProject(ProjectDTO dto) {

        String sql = """
                UPDATE projects
                SET
                    title=?,
                    description=?,
                    technologies=?,
                    github_link=?,
                    live_link=?,
                    image_url=?
                WHERE id=?
                """;

        return jdbcTemplate.update(
                sql,
                dto.getTitle(),
                dto.getDescription(),
                dto.getTechnologies(),
                dto.getGithubLink(),
                dto.getLiveLink(),
                dto.getImageUrl(),
                dto.getId());
    }

    @Override
    public int deleteProject(Long id) {

        String sql = "DELETE FROM projects WHERE id=?";

        return jdbcTemplate.update(sql, id);
    }
}