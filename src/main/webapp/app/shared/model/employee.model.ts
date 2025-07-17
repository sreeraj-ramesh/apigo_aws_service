import dayjs from 'dayjs';
import { IDepartment } from 'app/shared/model/department.model';
import { IJob } from 'app/shared/model/job.model';
import { IAddress } from 'app/shared/model/address.model';
import { IProject } from 'app/shared/model/project.model';

export interface IEmployee {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  phoneNumber?: string | null;
  hireDate?: dayjs.Dayjs;
  salary?: number | null;
  department?: IDepartment | null;
  job?: IJob | null;
  address?: IAddress | null;
  projects?: IProject[] | null;
}

export const defaultValue: Readonly<IEmployee> = {};
