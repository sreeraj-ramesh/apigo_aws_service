import React from 'react';
import { Route } from 'react-router';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Employee from './employee';
import Department from './department';
import Job from './job';
import Address from './address';
import Project from './project';
import Task from './task';
/* jhipster-needle-add-route-import - JHipster will add routes here */

export default () => {
  return (
    <div>
      <ErrorBoundaryRoutes>
        {/* prettier-ignore */}
        <Route path="employee/*" element={<Employee />} />
        <Route path="department/*" element={<Department />} />
        <Route path="job/*" element={<Job />} />
        <Route path="address/*" element={<Address />} />
        <Route path="project/*" element={<Project />} />
        <Route path="task/*" element={<Task />} />
        {/* jhipster-needle-add-route-path - JHipster will add routes here */}
      </ErrorBoundaryRoutes>
    </div>
  );
};
