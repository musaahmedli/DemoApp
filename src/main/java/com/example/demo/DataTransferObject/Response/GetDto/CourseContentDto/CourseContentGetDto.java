package com.example.demo.DataTransferObject.Response.GetDto.CourseContentDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseContentGetDto {
    Long Id;
    String Name;
    String Description;
    String MediaPath;
    String Level;

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

    public String getLevel() {

        return Level;
    }

    public void setLevel(String level) {

        Level = level;
    }

}
