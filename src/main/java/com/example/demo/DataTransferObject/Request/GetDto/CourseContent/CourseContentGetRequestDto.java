package com.example.demo.DataTransferObject.Request.GetDto.CourseContent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseContentGetRequestDto {
    Long Id;
    String Name;
    String Description;
    String MediaPath;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMediaPath() {
        return MediaPath;
    }

    public void setMediaPath(String mediaPath) {
        MediaPath = mediaPath;
    }
}
