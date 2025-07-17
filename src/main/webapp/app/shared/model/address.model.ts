export interface IAddress {
  id?: number;
  street?: string | null;
  city?: string | null;
  state?: string | null;
  country?: string | null;
  postalCode?: string | null;
}

export const defaultValue: Readonly<IAddress> = {};
