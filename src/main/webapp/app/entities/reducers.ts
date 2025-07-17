import employee from 'app/entities/employee/employee.reducer';
import department from 'app/entities/department/department.reducer';
import job from 'app/entities/job/job.reducer';
import address from 'app/entities/address/address.reducer';
import project from 'app/entities/project/project.reducer';
import task from 'app/entities/task/task.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  employee,
  department,
  job,
  address,
  project,
  task,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
