import dayjs from 'dayjs';
import { IProject } from 'app/shared/model/project.model';
import { TaskStatus } from 'app/shared/model/enumerations/task-status.model';

export interface ITask {
  id?: number;
  title?: string;
  description?: string | null;
  dueDate?: dayjs.Dayjs | null;
  status?: keyof typeof TaskStatus | null;
  project?: IProject | null;
}

export const defaultValue: Readonly<ITask> = {};
