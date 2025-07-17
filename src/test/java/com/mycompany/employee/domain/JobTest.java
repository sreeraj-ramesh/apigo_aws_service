package com.mycompany.employee.domain;

import static com.mycompany.employee.domain.JobTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.employee.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class JobTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Job.class);
        Job job1 = getJobSample1();
        Job job2 = new Job();
        assertThat(job1).isNotEqualTo(job2);

        job2.setId(job1.getId());
        assertThat(job1).isEqualTo(job2);

        job2 = getJobSample2();
        assertThat(job1).isNotEqualTo(job2);
    }
}
