import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Col, Row } from 'reactstrap';
import { TextFormat, Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './project.reducer';

export const ProjectDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const projectEntity = useAppSelector(state => state.project.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="projectDetailsHeading">
          <Translate contentKey="employeeApp.project.detail.title">Project</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{projectEntity.id}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="employeeApp.project.name">Name</Translate>
            </span>
          </dt>
          <dd>{projectEntity.name}</dd>
          <dt>
            <span id="startDate">
              <Translate contentKey="employeeApp.project.startDate">Start Date</Translate>
            </span>
          </dt>
          <dd>{projectEntity.startDate ? <TextFormat value={projectEntity.startDate} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="endDate">
              <Translate contentKey="employeeApp.project.endDate">End Date</Translate>
            </span>
          </dt>
          <dd>{projectEntity.endDate ? <TextFormat value={projectEntity.endDate} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <Translate contentKey="employeeApp.project.employees">Employees</Translate>
          </dt>
          <dd>
            {projectEntity.employees
              ? projectEntity.employees.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {projectEntity.employees && i === projectEntity.employees.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/project" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/project/${projectEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default ProjectDetail;
