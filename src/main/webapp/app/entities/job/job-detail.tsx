import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Col, Row } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './job.reducer';

export const JobDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const jobEntity = useAppSelector(state => state.job.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="jobDetailsHeading">
          <Translate contentKey="employeeApp.job.detail.title">Job</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{jobEntity.id}</dd>
          <dt>
            <span id="title">
              <Translate contentKey="employeeApp.job.title">Title</Translate>
            </span>
          </dt>
          <dd>{jobEntity.title}</dd>
          <dt>
            <span id="minSalary">
              <Translate contentKey="employeeApp.job.minSalary">Min Salary</Translate>
            </span>
          </dt>
          <dd>{jobEntity.minSalary}</dd>
          <dt>
            <span id="maxSalary">
              <Translate contentKey="employeeApp.job.maxSalary">Max Salary</Translate>
            </span>
          </dt>
          <dd>{jobEntity.maxSalary}</dd>
        </dl>
        <Button tag={Link} to="/job" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/job/${jobEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default JobDetail;
