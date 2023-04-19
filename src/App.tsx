import { useState } from "react";
import "./App.css";
import { Input, Button, message, Alert } from "antd";
import axios from "axios";

function App() {
  const [inputValue, setInputValue] = useState({
    productId: "",
    quantity: "",
  });
  const [loading, setLoading] = useState(false);
  const [result, setResult] = useState<string>("");

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setInputValue((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (inputValue.productId === "" || inputValue.quantity === "") return;
    setLoading(true);
    const res = await axios
      .get(
        `http://localhost:8080/?productId=${
          inputValue.productId
        }&quantity=${+inputValue.quantity}`
      )
      .finally(() => setLoading(false));
    if (!res.data) {
      message.error("Opps! Something went wrong!");
      return;
    }
    setResult(res.data);
    message.success("Get info successfully!");
  };

  return (
    <div className="h-screen bg-gray-200 flex items-center justify-center">
      <form
        className="w-[400px] bg-white rounded-md p-4"
        onSubmit={handleSubmit}
      >
        <div>
          ProductId: <Input name="productId" onChange={handleChange} />
        </div>
        <div className="mt-2">
          Quantity: <Input name="quantity" onChange={handleChange} />
        </div>
        <div className="flex justify-center">
          <Button
            htmlType="submit"
            className="mt-6"
            disabled={loading}
            loading={loading}
          >
            Submit
          </Button>
        </div>
        {result && (
          <Alert
            message={result}
            type="info"
            showIcon
            className="w-full mt-6"
          />
        )}
      </form>
    </div>
  );
}

export default App;
