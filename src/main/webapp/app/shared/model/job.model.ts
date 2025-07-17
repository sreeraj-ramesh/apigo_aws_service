export interface IJob {
  id?: number;
  title?: string;
  minSalary?: number | null;
  maxSalary?: number | null;
}

export const defaultValue: Readonly<IJob> = {};
