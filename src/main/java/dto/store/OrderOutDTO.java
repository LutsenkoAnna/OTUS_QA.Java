
package dto.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderOutDTO {
  private Boolean complete;
  private Integer id;
  private Integer petId;
  private Integer quantity;
  private String shipDate;
  private String status;
}
