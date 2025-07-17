export interface IDepartment {
  id?: number;
  name?: string;
  location?: string | null;
}

export const defaultValue: Readonly<IDepartment> = {};
