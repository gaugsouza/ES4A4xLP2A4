import React from 'react';
import renderer from 'react-test-renderer';

import Cadastro from '..\src\component\Cadastro.js';

describe('<Cadastro />', () => {
    it('should match the snapshot', () => {
      const component = renderer.create(<Cadastro />).toJSON();
      expect(component).toMatchSnapshot();
    });
  });