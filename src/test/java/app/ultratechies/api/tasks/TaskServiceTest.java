package app.ultratechies.api.tasks;

import app.ultratechies.api.exceptions.BadRequestException;
import app.ultratechies.api.utils.DateTimeUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @InjectMocks
    TaskService taskServiceMock;

    public static Task mockTask(){


        return Task.builder()
                .id(1L)
                .title("Test Title")
                .createdTime(DateTimeUtil.convertStringToInstant("2021-08-18 00:44:21.65"))
                .description("Lorem ipsum some task description")
                .dueDate(DateTimeUtil.convertStringToInstant("2021-08-18 00:44:21.65"))
                .status(TaskStatus.created)
                .build();
    }

    @Test
    @DisplayName("Given null dto validate not null then throw")
    public void givenNullTaskDTOThrowError(){
        assertThrows(
                BadRequestException.class,
                () -> taskServiceMock.checkForNull(null)
        );
    }

    @Test
    @DisplayName("Test Required fields validation on checkForNull")
    public void givenNullValuesValidateRequiredFields(){
      // title null check
        var dto1 = TaskDTO.builder()
                .createdTime("2021-08-18 00:44:21.65")
                .description("Lorem ipsum some task description")
                .dueDate("2021-08-18 00:44:21.65")
                .build();
        assertThrows(
                BadRequestException.class,
                () -> taskServiceMock.checkForNull(dto1)
        );

        // description null check
        var dto2 = TaskDTO.builder()
                .title("Some Title")
                .dueDate("2021-08-18 00:44:21.65")
                .createdTime("2021-08-18 00:44:21.65")
                .build();
        assertThrows(
                BadRequestException.class,
                () -> taskServiceMock.checkForNull(dto2)
        );

        // createdTime null check
        var dto3 = TaskDTO.builder()
                .title("Some Title")
                .description("Lorem ipsum some task description")
                .dueDate("2021-08-18 00:44:21.65")
                .build();
        assertThrows(
                BadRequestException.class,
                () -> taskServiceMock.checkForNull(dto3)
        );

        // Due date null check
        var dto4 = TaskDTO.builder()
                .title("Some Title")
                .description("Lorem ipsum some task description")
                .createdTime("2021-08-18 00:44:21.65")
                .build();
        assertThrows(
                BadRequestException.class,
                () -> taskServiceMock.checkForNull(dto4)
        );

        // createdTime null check
        var dto5 = TaskDTO.builder()
                .title("Some Title")
                .description("Lorem ipsum some task description")
                .dueDate("2021-08-18 00:44:21.65")
                .status(String.valueOf(TaskStatus.created))
                .build();
        assertThrows(
                BadRequestException.class,
                () -> taskServiceMock.checkForNull(dto5)
        );

    }

}