package org.example.springbootdeveloper.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springbootdeveloper.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(String author) {
        if (author == null || author.isBlank()) {  // 👈 author가 null 또는 빈 문자열이면 예외 발생
            throw new IllegalArgumentException("Author cannot be null or empty");
        }

        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}