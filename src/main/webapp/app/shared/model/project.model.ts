import dayjs from 'dayjs';
import { IEmployee } from 'app/shared/model/employee.model';

export interface IProject {
  id?: number;
  name?: string;
  startDate?: dayjs.Dayjs | null;
  endDate?: dayjs.Dayjs | null;
  employees?: IEmployee[] | null;
}

export const defaultValue: Readonly<IProject> = {};
