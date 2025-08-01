/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.rest.dto.task;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import org.camunda.bpm.engine.rest.dto.VariableValueDto;
import org.camunda.bpm.engine.task.Task;

public class TaskWithVariablesDto extends TaskDto {
  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  private Map<String, VariableValueDto> variables;

  public TaskWithVariablesDto() {
  }

  public TaskWithVariablesDto(Task task, Map<String, VariableValueDto> variables) {
    super(task);
    this.variables = variables;
  }

  public TaskWithVariablesDto(Task task) {
    super(task);
  }

  public Map<String, VariableValueDto> getVariables() {
    return variables;
  }

  public void setVariables(Map<String, VariableValueDto> variables) {
    this.variables = variables;
  }

  public static TaskDto fromEntity(Task task, Map<String, VariableValueDto> variables) {
    TaskWithVariablesDto result = new TaskWithVariablesDto(task);
    result.setVariables(variables);
    return result;
  }
}
